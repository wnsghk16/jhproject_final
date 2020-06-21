package com.jhproject.web.proxy;

import com.jhproject.web.owleague.Article;
import com.jhproject.web.owleague.ArticleRepository;
import com.jhproject.web.owleague.OWPlayer;
import com.jhproject.web.owleague.OWPlayerRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component("crawler") @Lazy
public class Crawler extends Proxy{
    @Autowired
    Box<String> box;
    @Autowired
    OWPlayerRepository owPlayerRepository;
    @Autowired
    ArticleRepository articleRepository;


    public void owPlayer(){
        try{
            String url = "https://overwatchleague.com/ko-kr/players";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Iterator<Element> ie = d.select("script#__NEXT_DATA__").iterator();
            String s = "";
            while (ie.hasNext()){
                s += ie.next().html();
            }

            JSONParser parser = new JSONParser();
            Object obj = parser.parse( s );
            JSONObject jsonObj = (JSONObject) obj;

            JSONObject a = (JSONObject) jsonObj.get("props");
            JSONObject b = (JSONObject) a.get("pageProps");
            JSONArray c = (JSONArray) b.get("blocks");
            JSONObject tmp = new JSONObject();
            JSONObject e = new JSONObject();
            for (int i = 0; i < c.size(); i++) {
                if(c.get(i).toString().contains("playerList")){
                    tmp = (JSONObject) c.get(i);
                    e = (JSONObject) tmp.get("playerList");
                }
            }
            JSONObject f = (JSONObject) e.get("tableData");
            JSONArray g = (JSONArray) f.get("data");
            OWPlayer owPlayer = null;
            for(int i=0;i < g.size(); i++){
                tmp = (JSONObject) g.get(i);
                owPlayer = new OWPlayer();
                owPlayer.setId(tmp.get("id").toString());
                owPlayer.setPlayer(tmp.get("name").toString());
                owPlayer.setPlayerimg(tmp.get("headshot").toString());
                owPlayer.setName(tmp.get("realName").toString());
                owPlayer.setHometown(tmp.get("hometown").toString());
                owPlayer.setTeamimg(tmp.get("teamImage").toString());
                owPlayer.setTeam(tmp.get("teamName").toString());
                owPlayer.setRole(tmp.get("role").toString());
                owPlayerRepository.save(owPlayer);
            }
        }catch(Exception e){
            print("에러 발생 "+e);
        }
    }

    public void article(){
        try{
            String url = "http://www.inven.co.kr/webzine/news/?site=overwatch";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements banner = d.select("img.banner");
            Elements title = d.select("span.title > a");
            Elements category = d.select("span.info > span.category:first-child");
            Elements info = d.select("span.info");
            print(info.toString());
            Article article = null;
            for(int i=0;i < banner.size(); i++){
                article = new Article();
                article.setBanner(banner.get(i).select("img").attr("src"));
                article.setTitle(title.get(i).text());
                article.setCategory(category.get(i).text());
                article.setAuthor(info.get(i).text().substring(6,34));
                article.setDate(info.get(i).text().substring(34));
                articleRepository.save(article);
            }
        }catch(Exception e){
            print("에러 발생"+2);
        }
    }
}

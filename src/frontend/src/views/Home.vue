<template>
  <div id="home">
    <banner />

    <about />

    <social />
  </div>
</template>

<script>

  export default {
    name: 'Home',
    components: {
      About: () => import('@/components/home/About'),
      Banner: () => import('@/components/home/Banner'),
      Social: () => import('@/components/home/Social'),
    },
  }
</script>

<template>
    <el-container class="outer">
        <el-aside width="200px" >
            <Aside class="aside"></Aside>
        </el-aside>
        <el-container>
            <el-header >Header</el-header>
            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    import Aside from './Aside'
    export default {
        name: "Manager",
        components:{
            Aside
        }
    }
</script>

<style scoped>
    .outer {
        position: fixed;
        top:0;
        right: 0;
        bottom: 0;
        left: 0;
    }
    .aside{
        height: 100%;
    }
</style>
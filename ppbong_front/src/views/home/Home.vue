<template>
    <div class="home">

        <div style="height: 1px"></div>
        <div class="nav">
            <div class="container">
                <div class="nav_inner">
                    <div class="nav_left">
                        <ul id="nav_ul">
                            <li class="item active"><a href="">抖音风</a></li>
                            <li class="item"><a href="">pmv</a></li>
                            <li class="item"><a href="">我要分享</a></li>
                        </ul>

                    </div>
                    <div class="nav_right">
                        <div class="input_search">
                            <el-input v-model="searchContent" placeholder="请输入内容"></el-input>
                        </div>
                        <div class="btn-search"><i class="el-icon-search" style="color: white"></i></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="show">
            <item-show></item-show>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import ItemShow from "@/components/ItemShow.vue"

    export default Vue.extend({
        name: 'Home',
        components: {
            ItemShow
        },
        data() {
            return {

                searchContent: "",
                imgsArr: []
            }
        }
    });
</script>
<style>


    /*    ================= nav =================*/
    .content {
        margin-top: 60px;
        width: 100%;
    }

    .nav {
        margin-top: 19px;
    }

    .nav_inner {
        background-color: black;
        height: 48px;
        display: flex;
        justify-content: space-between;
        font-family: inherit;
        font-weight: bold;
        font-size: 100%;
    }

    .nav_inner a {
        color: white;
        line-height: 48px;
    }

    #nav_ul {
        display: flex;
        justify-content: flex-start;
    }

    .item {
        padding: 0 12px;
    }

    .active {
        background-color: dodgerblue;
    }

    .nav_right {
        display: flex;
        justify-content: flex-start;
    }

    .input_search {
        margin: auto 0;

    }

    .el-input__inner {
        height: 30px !important;
    }

    .btn-search {
        width: 30px;
        line-height: 48px;
        font-size: 20px;
        text-align: center;
        margin: 0 10px;
        cursor: pointer;
    }


</style>

<template>
    <div id="layout">
        <div class="header">
            <div class="container">
                <div class="inner">
                    <div class="innerLeft">
                        <a href="/"><img :src="logo" width="55px" height="40px" alt=""></a>
                    </div>
                    <div class="innerRight">
                        <a href="/user/login" class="btn-login">立即登陆</a>
                        <a href="/user/reg" class="btn-reg">注册</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="content">
            <router-view></router-view>
        </div>
        <div class="fotter">
            <a href="http://www.miitbeian.gov.cn/" rel="external">
                <p>本站含有成人内容，未满18岁禁止进入！请遵守当地法规！<br>
                    This site contains adult content, no entry under 18! Please comply with local regulations!<br>
                    本站所发之内容均来自互联网。所有人物或模特均已满18岁。<br>
                    The contents posted on this site comes from the Internet.All persons/models were at least 18 years of
                    age when photographed.</p></a>
            "
            .             "
            <p></p>
            <p class="author">友链合作联系 <a href="mailto:ppbong@gmail.com">ppbong@gmail.com</a></p>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Layout",
        data(){
            return {
                logo: require("@/assets/ppbong.png"),
            }
        }
    }
</script>

<style scoped>
    .header {
        height: 59px;
        width: 100%;
        border-top: 1px solid #42b983;
        position: fixed;
        background-color: white;
        top: 0;
        z-index:999;
    }


    .inner {
        display: flex;
        justify-content: space-between;
        line-height: 34px;
        font-size: 14px;
        padding: 15px 0 0 0;
    }

    .inner a {
        padding: 0 12px;
        line-height: 34px;
        display: inline-block;
    }

    .btn-login {
        color: #009a61;
    }

    .btn-reg {
        background-color: #009a61;
        border-radius: 2px;
        color: white;
    }


    .fotter {

        border-top: 5px solid #09f;
        margin-top: 50px;
        text-align: center;
        background-color: #222;
        padding: 20px 0 15px 0;
        line-height: 1.5em;
        font-size: 12px;

    }
    .fotter a{
        color: #666;
    }
    .author {
        color: #666;
    }
</style>
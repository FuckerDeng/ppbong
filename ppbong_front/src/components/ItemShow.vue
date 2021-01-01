<template>
    <div id="item_show">
        <div class="container">
            <div class="content">
                <div class="c_left">
                    <div class="items">
                        <vue-waterfall-easy
                                :imgsArr="imgsArr"
                                :imgWidth="258.5"
                                :maxCols="3"
                                :loadingTimeOut="500"
                                @click="clickFn"
                            >
                            <div class="img-info" slot-scope="props">
                                <div class="title">

                                    <h3><a href="#">百度网盘秒传使用教程 毒盘资源和谐请在帖中留言</a></h3>
                                </div>
                                <div class="other">

                                    <p class="some-info"><i class="el-icon-date"> 时间 </i>&nbsp;&nbsp;<i class="el-icon-tickets">  分类</i></p>
                                </div>

                            </div>
                        </vue-waterfall-easy>
                    </div>

                    <div class="page">
                        <el-pagination
                                background
                                layout="prev, pager, next"
                                :total="1000">
                        </el-pagination>
                    </div>

                </div>
                <div class="c_right"></div>
            </div>
        </div>
    </div>
</template>

<script>
    import vueWaterfallEasy from 'vue-waterfall-easy'

    export default {
        components: {
            vueWaterfallEasy
        },
        name: "ItemShow",
        data() {
            return {
                imgsArr: [
                    {
                        src: "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2802998753,362775541&fm=26&gp=0.jpg",
                    },
                    {
                        src: "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fpic%2F7%2F62%2Fedbe398685.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1611629923&t=88b605e95e523abcee175937b2191c79",
                        href: "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2802998753,362775541&fm=26&gp=0.jpg"
                    },
                    {
                        src: "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fpic%2Fb%2F6d%2Fbd81507595.jpg&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1611629923&t=db49effda8544fc68fa621cabd064cca",
                        href: "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2802998753,362775541&fm=26&gp=0.jpg"
                    },
                    {
                        src: "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2802998753,362775541&fm=26&gp=0.jpg",
                        href: "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2802998753,362775541&fm=26&gp=0.jpg"
                    },
                    {
                        src: "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2802998753,362775541&fm=26&gp=0.jpg",
                        href: "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2802998753,362775541&fm=26&gp=0.jpg"
                    }
                ]
            }
        },
        methods:{
            clickFn(event, { index, value }) {
                // 阻止a标签跳转
                event.preventDefault()
                // 只有当点击到图片时才进行操作
                if (event.target.tagName.toLowerCase() == 'img') {
                    this.$router.push('/iteminfo')
                }
            }
        }
    }
</script>

<style scoped>
    #item_show {
        margin-top: 20px;;
    }

    .container {
        width: 1140px;
        margin: 0 auto;
        /*height: 20px;*/
        /*background-color: pink;*/
    }

    .content {
        display: flex;
        justify-content: space-between;

    }

    .c_left {
        flex-basis: 851.5px;

    }
    .items{
        height: 2000px;
    }

    .c_right {
        flex-basis: 278.5px;
        height: 10px;
        background-color: gray;
    }

    .vue-waterfall-easy-scroll {
        overflow-y: hidden !important;
    }

    .title {
        padding: 5px 5px;
        font-weight: 700;
    }
    .title a:hover{
        color: dodgerblue;
    }
    .other{
        border-top: 1px solid dodgerblue;
        height: 32px;
    }
    .some-info{
        text-align: center;
        line-height: 32px;
        color: #999;
    }
    .page{
        margin-top: 15px;
        width: 100%;
        text-align: center;
    }
    .img-info {
        background-color: white!important;
    }
</style>
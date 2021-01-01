import axios from 'axios'

const request = axios.create({
    baseURL:"http://localhost:8081",//基础url
    //发送拦截器
    //响应拦截器
})

const http = {
    get(url,queryParam){
        request({
            method:"get",
            url:url,
            data:queryParam
        }).then(r=>{
            return r.data;
        }).catch(e=>{

        })
    },
}

export  default request
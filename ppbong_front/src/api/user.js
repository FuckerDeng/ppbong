import http from '@/utils/http.js'

//登陆接口
export const login = data=>{
    return http({
        method:"post",
        url:"login",
        data:data,
    })
}
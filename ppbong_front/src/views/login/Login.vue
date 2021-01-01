<template>
    <div id="login">
        <div class="login_div">
            <el-form ref="form" :label-position="labelPosition" :rules="rules" label-width="80px" :model="loginForm">
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="loginForm.username"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input type="password" v-model="loginForm.password"></el-input>
                </el-form-item>
                <el-form-item cen>
                    <el-button :loading="loginLoading" class="btn_login" type="primary" @click="submitForm">登陆</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
    import {login} from '@/api/user.js'
    export default {
        name: "Login",
        data(){
            return {
                labelPosition: 'right',
                loginForm:{
                    username:"admin",
                    password:"123456"
                },
                loginLoading:false,
                rules: {
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 5, max: 16, message: '长度在 5 到 16 个字符', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                        {min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur'}
                    ]
                }
            }
        },
        methods:{
            submitForm(){
                this.$refs["form"].validate((valid,err)=>{
                    if(!valid){
                        return;
                    }
                    this.login();
                })

            },
            login(){
                this.loginLoading = true;
                login(this.loginForm).then((r)=>{
                    console.log(r)
                    if(r.data.code == 200 ){
                        this.loginLoading = false;
                        this.$router.push("/")
                        return;
                    }
                    this.loginLoading = false;
                    this.$message.error('登陆失败！请检查用户名或密码');

                }).catch(e=>{
                    this.loginLoading = false;
                    this.$message.error('登陆失败！');
                })
            }
        }
    }
</script>

<style scoped lang="less">
    #login {
        position: fixed;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        background: url("./login_bg.png") no-repeat;
        background-size: cover;
        .login_div {
            width: 350px;
            height: 250px;
            background-color: white;
            border-radius: 10px;
            margin: 0 auto;
            padding: 50px 20px 0 0;
        }
    }
    .btn_login {
        width: 100%;
    }

</style>
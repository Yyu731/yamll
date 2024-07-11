<script setup>
import Header from './cpns/Header.vue'
import {reactive} from 'vue'
import useUserStore from "@/stores/user.js";

const userStore = useUserStore()
const account = reactive({
  username: "",
  password: ""
})

const loginClick = () => {
  userStore.loginAction(account)
}

</script>

<template>
  <Header/>
  <div class="login">
    <div class="main">
      <div class="login-form-border">
        <div class="login-form">
          <div class="login-form-tips">
            <el-space size="small">
              <el-icon color="#FF860D">
                <Warning/>
              </el-icon>
              <el-text style="color:#FF860D" size="small" type="warning">
                洋芋不会以任何理由要求您转账，谨防诈骗
              </el-text>
            </el-space>
          </div>
          <div class="login-form-body">
            <el-tooltip
                class="box-item"
                effect="dark"
                content="扫码登录安全便捷"
                placement="left"
                visible
            >
              <div class="login-tab">
                <img src="@/assets/image/qrcode.png">
              </div>
            </el-tooltip>
            <div class="login-box">
              <el-space class="type" size="large">
                <el-text class="active" size="large" tag="b">密码登录</el-text>
                <el-text size="large">短信登录</el-text>
              </el-space>
              <div class="account-form">
                <el-input
                    v-model="account.username"
                    style="height: 34px;margin-bottom: 16px; font-size: 12px;"
                    placeholder="账号名/手机/邮箱"
                    clearable
                />
                <el-input
                    v-model="account.password"
                    style="height: 34px;margin-bottom: 8px; font-size: 12px;"
                    placeholder="密码"
                    clearable
                    show-password
                />
              </div>
              <div class="forget-pw">
                <el-link class="forget-text" :underline="false">
                  <el-text size="small">忘记密码</el-text>
                </el-link>
              </div>
              <div class="login-btn">
                <el-button class="btn" color="#FA2C19" @click="loginClick">
                  <el-space size="large">
                    <el-text tag="b" style="color: white">登</el-text>
                    <el-text tag="b" style="color: white">录</el-text>
                  </el-space>
                </el-button>
              </div>
            </div>
          </div>
          <div class="coagent">
            <el-space size="large">
              <div>
                <el-space size="small">
                  <div class="qq"/>
                  <el-text size="small">QQ</el-text>
                </el-space>
              </div>
              <div>
                <el-space size="small">
                  <div class="weixin"/>
                  <el-text size="small">微信</el-text>
                </el-space>
              </div>
            </el-space>
            <el-link>
              <el-text class="register" size="small">立即注册</el-text>
            </el-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">

.login {
  margin-top: 20px;
  height: 475px;
  background-color: #e93854;

  .main {
    position: relative;
    margin: 0 auto;
    height: 475px;
    width: 990px;
    background: url("@/assets/image/background.png") no-repeat 0 0;

    .login-form-border {
      position: absolute;
      display: flex;
      align-items: center;
      right: 0;
      height: 475px;
      width: 300px;

      .login-form {
        background-color: #FFFFFF;
        height: 335px;
        width: 300px;
        border-radius: 8px;
        overflow: hidden;

        .login-form-tips {
          display: flex;
          justify-content: center;
          align-items: center;
          height: 28px;
          background-color: #fff8f0;
        }

        .login-form-body {
          position: relative;
          padding: 12px 16px;
          height: 258px;
          width: 300px;
          box-sizing: border-box;

          .login-tab {
            position: absolute;
            top: 4px;
            right: 4px;
            width: 48px;
            height: 48px;

            img {
              width: 48px;
              height: 48px;
            }
          }

          .login-box {
            margin-top: 40px;

            .type {
              margin-bottom: 16px;

              .active {
                color: #FA2C19;
              }
            }

            .account-form {
              :deep(.el-input__wrapper) {
                box-shadow: rgb(220, 223, 230) 0px 0px 0px 1px inset
              }
            }

            .forget-pw {
              height: 25px;
              text-align: right;
              font-size: 12px;

              .forget-text {
                &:hover {
                  .el-text {
                    color: #E4393C;
                    text-decoration: underline #E4393C;
                  }
                }
              }
            }

            .login-btn {
              height: 36px;

              .btn {
                height: 100%;
                width: 100%;
                border-radius: 8px;
              }
            }
          }
        }

        .coagent {
          display: flex;
          justify-content: space-between;
          align-items: center;
          padding: 0 20px;
          height: 49px;
          background-color: #F6F6F6;

          .qq,
          .weixin {
            width: 19px;
            height: 18px;
            background-color: #b1191a;
          }

          .qq {
            background: url("@/assets/image/QQ-weixin.png");
          }

          .weixin {
            background: url("@/assets/image/QQ-weixin.png") 19px 0;
          }
        }
      }
    }
  }
}
</style>
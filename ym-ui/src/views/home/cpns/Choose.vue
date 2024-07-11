<script setup>
import {storeToRefs} from "pinia";
import useUserStore from "@/stores/user.js";

const userStore = useUserStore()
const {userInfo} = storeToRefs(userStore)
</script>

<template>
  <div class="main">
    <div class="container">
      <div class="choose">
        <div class="left">
          <div class="item">
            <el-link :underline='false'>图书、音箱、数字商品</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>家用电器</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>手机、数码</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>电脑、办公</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>家具、家具、家装、厨具</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>服饰内衣</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>个护化妆</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>运动健康</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>汽车用品</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>彩票、旅行</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>理财、众筹</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>母婴、玩具</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>箱包</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>五金</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>运动户外</el-link>
          </div>
          <div class="item">
            <el-link :underline='false'>其他</el-link>
          </div>
        </div>
        <div class="center">
          <el-carousel height="470px">
            <el-carousel-item>
              <img class="pic" src="../../../assets/image/banner/1.png">
            </el-carousel-item>
            <el-carousel-item>
              <img class="pic" src="../../../assets/image/banner/2.png">
            </el-carousel-item>
            <el-carousel-item>
              <img class="pic" src="../../../assets/image/banner/3.png">
            </el-carousel-item>
            <el-carousel-item>
              <img class="pic" src="../../../assets/image/banner/4.png">
            </el-carousel-item>
            <el-carousel-item>
              <img class="pic" src="../../../assets/image/banner/5.png">
            </el-carousel-item>
            <el-carousel-item>
              <img class="pic" src="../../../assets/image/banner/6.png">
            </el-carousel-item>
          </el-carousel>
        </div>
        <div class="right">
          <div class="user-container">
            <div class="user-info">
              <div class="avatar">
                <img src="../../../assets/image/logo.png">
              </div>
              <div class="tip">
                <el-text size="small">Hi~欢迎逛洋芋</el-text>
              </div>
              <div class="login">
                <template v-if="userInfo.username">
                  <el-text size="small" type="warning">{{ userInfo.username }}</el-text>
                </template>
                <template v-else>
                  <el-text size="small">登录</el-text>
                  <el-text size="small">注册</el-text>
                </template>
              </div>
            </div>
            <div class="user-right">
              <div class="vip plus">
                <el-text class="title" style="color: #663300" tag="b" size="small">Plus会员</el-text>
                <el-text class="subtitle" style="color: #A88100" size="small">无限免邮</el-text>
                <el-text class="open" style="color: #663300" size="small">立即开通
                  <el-icon>
                    <ArrowRight/>
                  </el-icon>
                </el-text>
              </div>
              <div class="company vip">
                <el-text class="title" style="color: #054180" tag="b" size="small">企业会员</el-text>
                <el-text class="subtitle" style="color: #3369A5" size="small">体验津贴3000元</el-text>
                <el-text class="open" style="color: #054180" size="small">立即开通
                  <el-icon>
                    <ArrowRight/>
                  </el-icon>
                </el-text>
              </div>
            </div>
          </div>
          <div class="category">
            <div class="item">
              <img class="icon" src="../../../assets/image/catogory/ecard.png"/>
              <el-text size="small" type="info">礼品卡</el-text>
            </div>
            <div class="item">
              <img class="icon" src="../../../assets/image/catogory/jiayou.png"/>
              <el-text size="small" type="info">加油卡</el-text>
            </div>
            <div class="item">
              <img class="icon" src="../../../assets/image/catogory/huafei.png"/>
              <el-text size="small" type="info">花费</el-text>
            </div>
            <div class="item">
              <img class="icon" src="../../../assets/image/catogory/youxi.png"/>
              <el-text size="small" type="info">游戏</el-text>
            </div>
            <div class="item">
              <img class="icon" src="../../../assets/image/catogory/jiudian.png"/>
              <el-text size="small" type="info">酒店</el-text>
            </div>
            <div class="item">
              <img class="icon" src="../../../assets/image/catogory/yunjianzhan.png"/>
              <el-text size="small" type="info">云建站</el-text>
            </div>
            <div class="item">
              <img class="icon" src="../../../assets/image/catogory/wujincheng.png"/>
              <el-text size="small" type="info">五金城</el-text>
            </div>
            <div class="item">
              <img class="icon" src="../../../assets/image/catogory/plushuiyuan.png"/>
              <el-text size="small" type="info">PLUS会员</el-text>
            </div>
            <div class="item">
              <img class="icon" src="../../../assets/image/catogory/qiyehuiyuan.png"/>
              <el-text size="small" type="info">企业会员</el-text>
            </div>
            <div class="item">
              <img class="icon" src="../../../assets/image/catogory/qicai.png"/>
              <el-text size="small" type="info">企采场景购</el-text>
            </div>
          </div>
          <div class="other">
            <el-text tag="b" size="large">敬请期待</el-text>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">

.choose {
  display: flex;

  .left {
    display: flex;
    flex-direction: column;
    padding: 0 20px;
    width: 210px;
    height: 480px;
    box-sizing: border-box;
    background-color: #c81623;

    .item {
      height: 30px;
      display: flex;
      align-items: center;

      .el-link {
        color: white;

        &:hover {
          font-weight: 700;
        }
      }
    }
  }

  .center {
    height: 480px;
    width: 610px;
    padding: 10px 10px 0;
    box-sizing: border-box;

    .pic {
      height: 100%;
    }
  }

  .right {
    height: 480px;
    width: 380px;

    .user-container {
      display: flex;
      margin-top: 10px;
      height: 98px;
      border: 1px solid #EAEAEA;

      .user-info {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 96px;
        width: 116px;

        .avatar {
          width: 28px;
          height: 28px;

          img {
            height: 100%;
            width: 100%;
            object-fit: contain;
          }
        }

        .tip {
          margin: 4px 0 2px;
        }

        .login {
          .el-text {
            margin: 0 2px;
          }
        }
      }

      .user-right {
        flex: 1;
        display: flex;
        align-items: center;

        .vip {
          display: flex;
          flex-direction: column;
          padding: 8px 10px;
          height: 80px;
          width: 124px;
          box-sizing: border-box;

          .el-text {
            align-self: flex-start;
          }

          .title {
            font-size: 13px;
          }

          .subtitle {
            margin-top: 4px;
            font-size: 11px;
          }

          .open {
            margin-top: 10px;
            font-size: 11px;
          }
        }

        .plus {
          background-image: url("../../../assets/image/vip/plus.png");
          background-size: cover;
          border-radius: 4px;

        }

        .company {
          margin-left: 6px;
          background-image: url("../../../assets/image/vip/company.png");
          background-size: cover;
          border-radius: 4px;
        }
      }
    }

    .category {
      display: flex;
      justify-content: space-between;
      flex-wrap: wrap;
      margin-top: 10px;
      height: 178px;
      border: 1px solid #EAEAEA;

      .item {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: 74px;
        height: 86px;

        .icon {
          height: 48px;
          width: 48px;
          margin-bottom: 2px;
          object-fit: contain;
        }
      }
    }

    .other {
      display: flex;
      justify-content: center;
      align-items: center;
      margin-top: 10px;
      height: 168px;
      border: 1px solid #EAEAEA;

      .el-text {
        font-size: 30px;
      }
    }
  }
}
</style>
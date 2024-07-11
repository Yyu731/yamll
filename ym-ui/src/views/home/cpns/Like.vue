<script setup>

</script>

<template>
  <div class="container">
    <div class="like">
      <el-text class="title" tag="b" size="large">猜你喜欢</el-text>
      <div class="like-list">
        <div class="item">
          <img class="image" src="../../../assets/image/like/like_01.png"/>
          <el-text line-clamp="2">
            阳光美包新款单肩包女包时尚子母包四件套女阳光美包新款单肩包女包时尚子母包四件套女
          </el-text>
          <el-text class="price" tag="b">￥<el-text class="num">188</el-text> </el-text>
        </div>
        <div class="item">
          <img class="image" src="../../../assets/image/like/like_02.png"/>
          <el-text line-clamp="2">
            阳光美包新款单肩包女包时尚子母包四件套女阳光美包新款单肩包女包时尚子母包四件套女
          </el-text>
          <el-text class="price" tag="b">￥<el-text class="num">188</el-text> </el-text>
        </div>
        <div class="item">
          <img class="image" src="../../../assets/image/like/like_03.png"/>
          <el-text line-clamp="2">
            阳光美包新款单肩包女包时尚子母包四件套女阳光美包新款单肩包女包时尚子母包四件套女
          </el-text>
          <el-text class="price" tag="b">￥<el-text class="num">188</el-text> </el-text>
        </div>
        <div class="item">
          <img class="image" src="../../../assets/image/like/like_01.png"/>
          <el-text line-clamp="2">
            阳光美包新款单肩包女包时尚子母包四件套女阳光美包新款单肩包女包时尚子母包四件套女
          </el-text>
          <el-text class="price" tag="b">￥<el-text class="num">188</el-text> </el-text>
        </div>
        <div class="item">
          <img class="image" src="../../../assets/image/like/like_02.png"/>
          <el-text line-clamp="2">
            阳光美包新款单肩包女包时尚子母包四件套女阳光美包新款单肩包女包时尚子母包四件套女
          </el-text>
          <el-text class="price" tag="b">￥<el-text class="num">188</el-text> </el-text>
        </div>
        <div class="item">
          <img class="image" src="../../../assets/image/like/like_03.png"/>
          <el-text line-clamp="2">
            阳光美包新款单肩包女包时尚子母包四件套女阳光美包新款单肩包女包时尚子母包四件套女
          </el-text>
          <el-text class="price" tag="b">￥<el-text class="num">188</el-text> </el-text>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">

.like {
  margin-top: 10px;

  .title {
    font-size: 20px;
  }

  .like-list {
    display: flex;
    justify-content: space-between;
    margin-top: 8px;
    height: 280px;
    border: 1px solid #EAEAEA;
    box-sizing: border-box;

    .item {
      display: flex;
      flex-direction: column;
      height: 100%;
      width: 190px;
      padding: 20px 20px 0;
      box-sizing: border-box;

      .image {
        margin-bottom: 12px;
        width: 142px;
        height: 142px;
        align-self: center;
      }
      .price {
        margin-top: 14px;
        color: #df3033;
        font-size: 22px;
        .num {
          color: #df3033;
          font-size: 22px;
        }
      }
    }
  }
}
</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

  <div class="header">
    <h1 class="site_logo"><a href="menu.html">商品管理システム</a></h1>
    <div class="user">
      <p class="user_name">${User.getName()}</p>
      <form class="logout_form" action="logout" method="get">
        <button class="logout_btn" type="submit">
          <img src="images/ドアアイコン.png">ログアウト</button>
      </form>
    </div>
  </div>

  <hr>
             

  <div class="update">
    <div class="form_body">
      <div class="img_block">
        <img src="images/マッキー.png" class="product_img"><br>
      </div>
      <form>
        <fieldset class="label-130 product_block">
          <p class="error">エラーメッセージ</p>
          <div>
            <label>商品ID</label>
            <input type="text" name="loginId" value=${product.getProduct_id() } readonly class="base-text">
          </div>
          <div>
            <label>商品名</label>
            <input type="text" name="userName" value=${product.getName() } readonly class="base-text">
          </div>
          <div>
            <label>単価</label>
            <input type="text" name="tel" value=${product.getPrice() } readonly class="base-text">
          </div>
          <div>
            <label>カテゴリ</label>
            <input type="text" name="roleName" value=${product.getCategory()} readonly class="base-text">
          </div>
          <div>
            <label>商品説明</label>
            <textarea name="description" readonly class="base-text" style="background-color: rgb(209, 209, 209);">
${product.getDescription()}
            </textarea>

          </div>
        </fieldset>
        <div>
          <div class="btns">
            <input type="button" onclick="openModal()" value="削除" class="basic_btn">
            <input type="button" onclick="location.href='update'" value="編集" class="basic_btn">
            <input type="button" onclick="location.href='back'" value="戻る" class="cancel_btn">
          </div>
          

          
        </div>
      </form>
    </div>
  </div>     
       <form:form  action="/edit">
          <div id="modal">
            <p class="modal_message">削除しますか？</p>
            <div class="btns">
              <button type="submit" class="basic_btn">削除</button>
              <button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</button>
            </div>
          </div>
          </form:form>
  <div id="fadeLayer"></div>
</body>
</html>
<script src="./js/commons.js"></script>
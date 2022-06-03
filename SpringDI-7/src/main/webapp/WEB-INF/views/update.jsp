<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <div class="header">
    <h1 class="site_logo"><a href="back">商品管理システム</a></h1>
    <div class="user">
      <p class="user_name">${Username}さん、こんにちは</p>
    <form class="logout_form" action="logout" method="get">
        <button class="logout_btn" type="submit">
          <img src="images/ドアアイコン.png">ログアウト</button>
      </form>
    </div>
  </div>

  <hr>

  <div class="insert">
    <div class="form_body">
      ${erroridmsg}

      <form:form action="updatetable" method="post" modelAttribute="update">
        <fieldset class="label-130">
          <div>
            <label>商品ID</label>
            <form:input type="number" path="productId" class="base-text"/>
             <form:errors path="productId" cssStyle="color: red"/>
          </div>
          <div>
            <label>商品名</label>
            <form:input type="text" path="name" class="base-text"/>
           <form:errors path="name" cssStyle="color: red"/>
          </div>
          <div>
            <label>単価</label>
            <form:input type="number" path="price" class="base-text"/>
            <form:errors path="price" cssStyle="color: red"/>
          </div>
          <div>
            <label>カテゴリ</label> <form:select path="categoryId" class="base-text">
              <option value="1" selected>筆記具</option>
              <option value="2">紙製品</option>
              <option value="3">事務用品</option>
              <option value="4">オフィス機器</option>
              <option value="5">雑貨</option>
            </form:select>
          </div>
          <div>
            <label>商品説明</label>
            <form:textarea path="description" class="base-text"></form:textarea>
          </div>
          <div>
            <label>画像</label>
            <form:input type="file" path="file"/>
            <span class="error">エラーメッセージ</span>
          </div>
        </fieldset>
          <div class="btns">
            <button type="button" onclick="openModal()" class="basic_btn">更新</button>
            <input type="button" onclick="location.href='back'" value="メニューに戻る" class="cancel_btn">
          </div>
          <div id="modal">
            <p class="modal_message">更新しますか？</p>
            <div class="btns">
              <button type="submit" class="basic_btn">更新</button>
              <button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</button>
            </div>
          </div>
      </form:form>
    </div>
  </div>
  <div id="fadeLayer"></div>
</body>
</html>
<script src="./js/commons.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

  <div class="header">
    <h1 class="site_logo"><a href="menu.html">商品管理システム</a></h1>
    <div class="user">
      <p class="user_name">${User.getName()}</p>
      <form class="logout_form" action="logout.jsp" method="get">
        <button class="logout_btn" type="submit">
          <img src="images/ドアアイコン.png">ログアウト</button>
      </form>
    </div>
  </div>

  <hr>
  
  <div class="insert">
    <div class="discription">
      <p>
        登録情報を入力してください（<span class="required"></span>は必須です）
      </p>
    </div>
  
    <div class="form_body">
      <p class="error">${msg}</p>
  
      <form:form action="insert" method="post" modelAttribute="insert">
        <fieldset class="label-130">
          <div>
            <label class="required">商品ID</label>
            <form:input type="number" path="productId" class="base-text"/><form:errors path="productId" cssStyle="color: red"/>

          </div>
          <div>
            <label class="required">商品名</label>
            <form:input type="text" path="name" class="base-text"/><form:errors path="name" cssStyle="color: red"/>

          </div>
          <div>
            <label class="required">単価</label>
            <form:input type="number" path="price" class="base-text"/><form:errors path="price" cssStyle="color: red"/>
          </div>
          <div class="select_block">
            <label class="required">カテゴリ</label>
            <form:select path="categoryId" class="base-text">
              <form:option value="1">筆記具</form:option>
              <form:option value="2">紙製品</form:option>
              <form:option value="3">事務消耗品</form:option>
              <form:option value="4">オフィス機器</form:option>
              <form:option value="5">雑貨</form:option>
            </form:select>
          </div>
          <div>
            <label>商品説明</label>
            <form:textarea path="description" class="base-text"></form:textarea>
          </div>
          <div>
            <label>画像</label>
            <form:input type="file" path="file"/>
            <span class="error">  </span>
          </div>
        </fieldset>
        <div class="btns">
          <button type="submit" onclick="openModal(modal)" class="basic_btn" >登録</button>
          <input type="button" onclick="location.href='back'" value="戻る" class="cancel_btn">
        </div>
        
        <div id="modal">
          <p class="modal_message">登録しますか？</p>
          <div class="btns">
            <button type="submit" class="basic_btn">登録</button>
            <button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</button>
          </div>
          
        </div>
      </form:form>
    </div>
  </div>
  <div id="fadeLayer"></div>
</body>
</html>
<script src="${pageContext.request.contextPath}/js/commons.js">


</script>
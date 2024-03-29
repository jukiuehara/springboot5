<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
<link href="css/commons.css" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>


  <div id="app">

    <div class="header">
      <h1 class="site_logo"><a href="menu.html">商品管理システム</a></h1>
      <div class="user">
        <p class="user_name">${Username}さん、こんにちは</p>
    <form class="logout_form" action="logout" method="get">
        <button class="logout_btn" type="submit">
            <img src="images/ドアアイコン.png">ログアウト</button>
        </form>
      </div>
    </div>

    <hr>
  <c:choose>
    <c:when test="${Role eq 1}">
    <div class="btn"><a class="basic_btn regist" href="/in">新規登録</a></div>
    <p>${deletemsg}</p>
    </c:when>
    <c:otherwise>

    </c:otherwise>
  </c:choose>

    <form method="get" action="/menu">
    <div class="search_container">
      <input type="text" size="25" placeholder="キーワード検索" name="key">
      <input type="submit" value="&#xf002">
	</div>

        <div class="caption"><p>検索結果：${count}件</p></div>
        <div class="order">

          <select class="base-text" name="category" >
            <option>並び替え</option>
            <option value="id">商品ID</option>
            <option value="category">カテゴリ</option>
            <option value="lowprice">単価：安い順</option>
            <option value="heigtprice">単価：高い順</option>
            <option value="oldprice">登録日：古い順</option>
            <option value="newprice">登録日：新しい順</option>
          </select>         
        </div>
       </form>   
       
     <table>        
      <thead>
        <tr>
          <th>商品ID</th>
          <th>商品名</th>
          <th>単価</th>
          <th>カテゴリ</th>
          <th>詳細</th>
        </tr>
      </thead>

      <tbody>        
        <template v-for="product in products">      
          <c:forEach var="product" items="${list}">      
          <tr>
            <td>${fn:escapeXml(product.getProduct_id()) }</td>
            <td>${fn:escapeXml(product.getName()) }</td>
            <td>${fn:escapeXml(product.getPrice()) }</td>
            <td>${fn:escapeXml(product.getCategory()) }</td>
            
            <td><a class="detail_btn" href="/detail?name=${product.getProduct_id()} " >詳細</a></td>
          </tr>        

        </c:forEach> 
        </template>        

        

      </tbody>
    </table>
    


    
  </div>
  <footer></footer>

  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>
  <script>
    const vie = new Vue({
      el: "#app",
      data: {
        products: [
          {
            ID: "10001",
            name: "マッキー(黒)",
            price: 160,
            category: "筆記具",
          }
        ]
      }
    })

  </script>
</body>
</html>
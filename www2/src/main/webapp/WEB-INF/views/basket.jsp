<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <style>
                body {
                        margin: 0;
                }

                * {
                        box-sizing: border-box;
                }

                p,
                span {
                        margin: 0;
                }

                a {
                        color: black;
                }

                img {
                        display: block;
                        width: 80%;
                        height: 80px;
                        margin: auto;
                }

                .cart {
                        width: 80%;
                        margin: auto;
                        padding: 30px;
                }

                .cart ul {
                        background-color: whitesmoke;
                        padding: 30px;
                        margin-bottom: 50px;
                        border: whitesmoke solid 1px;
                        border-radius: 5px;
                        font-size: 13px;
                        font-weight: 300;
                }

                .cart ul :first-child {
                        color: limegreen;
                }

                table {
                        border-top: solid 1.5px black;
                        border-collapse: collapse;
                        width: 100%;
                        font-size: 14px;
                }

                thead {
                        text-align: center;
                        font-weight: bold;
                }

                tbody {
                        font-size: 12px;
                        text-align: center;
                }

                td {
                        padding: 15px 0px;
                        border-bottom: 1px solid lightgrey;
                }

                .cart__list__detail :nth-child(3) {
                        vertical-align: top;
                }

                .cart__list__detail :nth-child(3) a {
                        font-size: 12px;
                }

                .cart__list__detail :nth-child(3) p {
                        margin-top: 6px;
                        font-weight: bold;
                }

                .cart__list__smartstore {
                        font-size: 12px;
                        color: gray;
                }

                .cart__list__option {
                        vertical-align: top;
                        padding: 20px;
                }

                .cart__list__option p {
                        margin-bottom: 25px;
                        position: relative;
                }

                .cart__list__option p::after {
                        content: "";
                        width: 90%;
                        height: 1px;
                        background-color: lightgrey;
                        left: 0px;
                        top: 25px;
                        position: absolute;
                }

                .cart__list__optionbtn {
                        background-color: white;
                        font-size: 10px;
                        border: lightgrey solid 1px;
                        padding: 7px;
                }

                .cart__list__detail :nth-child(4),
                .cart__list__detail :nth-child(5),
                .cart__list__detail :nth-child(6) {
                        border-left: 2px solid whitesmoke;
                }

                .cart__list__detail :nth-child(5),
                .cart__list__detail :nth-child(6) {
                        text-align: center;
                }

                .cart__list__detail :nth-child(5) button {
                        background-color: limegreen;
                        color: white;
                        border: none;
                        border-radius: 5px;
                        padding: 4px 8px;
                        font-size: 12px;
                        margin-top: 5px;
                }

                .price {
                        font-weight: bold;
                }

                .cart__mainbtns {
                        width: 420px;
                        height: 200px;
                        padding-top: 40px;
                        display: block;
                        margin: auto;
                }

                .cart__bigorderbtn {
                        width: 200px;
                        height: 50px;
                        font-size: 16px;
                        margin: auto;
                        border-radius: 5px;
                        background-image: url('<%=request.getContextPath()%>/resources/img/Bruno.png');
                        background-size: 200px 50px;
                }

                .cart__bigorderbtn.left {
                        border: 1px lightgray solid;
                }

                .cart__bigorderbtn.right {
                        background-color: limegreen;
                        color: white;
                        border: none;
                }

                input[type=number]::-webkit-inner-spin-button {
                        opacity: 1
                }
        </style>
</head>

<body>
        <section class="cart">
                <div class="cart__information">
                        <ul>
                                <li>장바구니 상품은 최대 30일간 저장됩니다.</li>
                                <li>가격, 옵션 등 정보가 변경된 경우 주문이 불가할 수 있습니다.</li>
                                <li>오늘출발 상품은 판매자 설정 시점에 따라 오늘출발 여부가 변경될 수 있으니 주문 시 꼭 다시 확인해 주시기 바랍니다.</li>
                        </ul>
                </div>
                <table class="cart__list" id="cart__del">
                        <form>
                                <thead id="cart__head">
                                        <tr>
                                                <td><input type="checkbox" id="allChk" onchange="allChk1()"></td>
                                                <td>상품정보</td>
                                                <td>옵션</td>
                                                <td>상품금액</td>
                                                <td>배송비</td>
                                        </tr>
                                        <tr id="hidden">
                                                <td colspan="5"> 장바구니가 비어있습니다. 물건을 주문해주세요.</td>
                                        </tr>
                                </thead>
                                <tbody id="cart__list">
                                        <!-- <tr class="cart__list__detail">
            <td><input type="checkbox"></td>
            <td> </td>
            <td class="cart__list__option">
              
            </td>
            <td><span class="price"></span><br>

            </td>
            <td></td>
          </tr>
          <tr class="cart__list__detail">
            <td style="width: 2%;"><input type="checkbox"></td>

            <td style="width: 40%;">
            </td>
            <td class="cart__list__option" style="width: 27%;">

            </td>
            <td style="width: 15%;"><span class="price"></span><br>

            </td>
            <td style="width: 15%;"></td>
          </tr>-->
                                </tbody>
                                <tfoot>
                                        <tr>
                                                <td colspan="2"><input type="checkbox"> <input type="button"
                                                                class="cart__list__optionbtn" onclick="delRow()"
                                                                value="선택상품삭제">
                                                        <button class="cart__list__optionbtn">선택상품 찜</button>
                                                </td>
                                                <td></td>
                                                <td style="text-align: center;"> 선택상품금액 <span id="allGoods"></span> + 총
                                                        배송비 <span id="allDlv"></span></td>
                                                <td
                                                        style="text-align: center; color: limegreen; border-left: 1px lightgray solid;">
                                                        주문금액 <span id="allPri"></span></td>
                                        </tr>
                                </tfoot>
                        </form>
                </table>

                <table class="buyGoods">
                        <form>
                                <thead>
                                        <tr>
                                                <td>상품정보</td>
                                                <td>옵션</td>
                                                <td>상품금액</td>
                                                <td>배송비</td>
                                        </tr>
                                </thead>
                                <tbody>
                                        <tr class="cart__list__detail">

                                                <td style="width: 40%;"><input type="text" id="goodsInfo" value="" size="40">
                                                </td>
                                                <td class="cart__list__option" style="width: 27%;">
                                                        상품 주문 수량<input type="number" id="goodsCnt" min="1" value="1"
                                                                style="width: 40px;">개
                                                </td>
                                                <td style="width: 15%;"><span class="price"><input type="text"
                                                                        id="goodsPrice" size="10">원</span>
                                                </td>
                                                <td style="width: 15%;"><input type="text" id="goodsDlv" size="10"></td>
                                        </tr>

                                </tbody>

                        </form>
                </table>
                <div class="cart__mainbtns">
                        <button class="cart__bigorderbtn left">쇼핑 계속하기</button>
                        <button class="cart__bigorderbtn right" onclick="addRow()">주문하기</button>
                </div>
        </section>
</body>

<script>
        // 주문하기 버튼 클릭시 실행되는 함수 정의
        // 체크박스, 상품정보, 옵션, 상품금액, 배송비 입력(모든 입력칸이 입력되어야 입력 가능) 및 가격 계산 함수 호출
        function addRow() {
                // class = "buyGoods"(tbody)의 input에 입력되는 값을 변수를 선언하여 저장
                // 여러번 사용되며, 코드의 길이를 줄여 효율적으로 사용가능
                // 함수가 한번 실행 되는 동안 입력값은 변하지 않으므로, const(상수화)로 변수를 선언
                const input = document.getElementById("goodsInfo").value;
                const option = document.getElementById("goodsCnt").value;
                const price = document.getElementById("goodsPrice").value;
                const dlv = document.getElementById("goodsDlv").value;
                // 입력값이 비어있을 경우(입력되지 않았을 경우 경고창을 띄우고 다시 입력할 수 있도록 설정)
                if (input == "") {
                        alert("상품정보가 누락되어 있습니다.")
                        return;
                }
                if (price == "") {
                        alert("상품금액이 누락되어 있습니다.")
                        return;
                }
                if (dlv == "") {
                        alert("배송비가 누락되어 있습니다.")
                        return;
                }
                // 입력된 값을 장바구니 정보에 열로 추가하기 위해 테이블 row와 column 생성
                let newOrder = cart__list.insertRow();
                let cell1 = newOrder.insertCell(0);
                let cell2 = newOrder.insertCell(1);
                let cell3 = newOrder.insertCell(2);
                let cell4 = newOrder.insertCell(3);
                let cell5 = newOrder.insertCell(4);
                // 생성된 row의 각 column에 입력값 출력
                // input type이 checkbox로, 전체 선택 및 전체 선택 해제에 활용하기 위해 name을 "checking"으로 설정
                cell1.innerHTML = "<input type = \"checkbox\" name = \"checking\">";
                cell2.innerHTML = input;
                cell3.innerHTML = option + " 개";
                cell4.innerHTML = price + " 원";
                cell5.innerHTML = dlv + " 원";
                // 장바구니에 상품이 등록될 경우 필요없는 row("장바구니가 비어있습니다. 물건을 주문해주세요.") 문구 삭제
                if (document.getElementById("hidden") != null) {
                        cart__del.deleteRow(1);
                }
                // 계산 함수 호출
                calculatePrice();
        }

        // 가격 계산 함수 정의
        function calculatePrice() {
                // 필요한 값을 저장할 수 있는 변수 선언
                let totalGoodsPrice = 0;
                let totalDeliveryPrice = 0;
                let totalPrice = 0
                // 장바구니에 입력되어있는 row를 돌면서 금액을 계산
                for (let i = 0; i < cart__list.rows.length; i++) {
                        // row들의 column에 숫자를 제외한 문자를 삭제하기위한 정규식 활용
                        var removeString = /[^0-9]/g;
                        // replace를 활용하여 문자 제거 후 parseInt로 자료형 변환 및 계산
                        totalGoodsPrice += parseInt(cart__list.rows[i].cells[2].innerHTML.replace(removeString, "")) * parseInt(cart__list.rows[i].cells[3].innerHTML.replace(removeString, ""));
                        totalDeliveryPrice += parseInt(cart__list.rows[i].cells[4].innerHTML.replace(removeString, ""))
                }
                // 계산이 완료된 값 출력
                document.getElementById("allGoods").innerHTML = totalGoodsPrice + " 원";
                document.getElementById("allDlv").innerHTML = totalDeliveryPrice + " 원";
                document.getElementById("allPri").innerHTML = totalDeliveryPrice + totalGoodsPrice + " 원";
        }

        // 등록 상품 제거 및 계산 함수 호출
        function delRow() {
                // row를 돌면서 체크박스의 체크여부 검토 및 체크되어있는 row 삭제
                for (let i = 0; i < cart__list.rows.length; i++) {
                        // checkbox의 check 여부 검토를 위한 조건문
                        if (cart__list.rows[i].cells[0].children[0].checked) {
                                // check되어 있을 시, 해당 row 삭제
                                cart__list.deleteRow(i);
                                // row가 삭제될 시, 앞으로 수행될 row의 index값이 1씩 감소하게 되므로, -- 연산자 사용하여 i 값을 1만큼 감소시킨 후 반복수행
                                i--;
                        }
                }
                // 등록된 상품이 모두 제거되었을 경우 기존 "장바구니가 비어있습니다. 물건을 주문해주세요." 문구를 추가해주기 위한 조건문
                // 장바구니에 등록된 상품이 없는 경우를 상품 row의 길이가 0인 경우로 하여 조건문 설정
                if (document.getElementById("cart__list").rows.length == 0) {
                        if(document.getElementById("hidden") == null) {
                                // 문구 입력을 위한 row와 column 추가
                                let emptyRow = cart__head.insertRow();
                                emptyRow.id = "hidden";
                                let cell1 = emptyRow.insertCell(0);
                                // 입력된 문구를 5개의 병합된 cell에 입력하기 위해 colSpan 메서드 활용
                                cell1.colSpan = "5";
                                // 만들어진 column에 문구 입력
                                cell1.innerHTML = "장바구니가 비어있습니다. 물건을 주문해주세요.";
                        }
                }
                // 등록상품 제거 시, 값이 달라지게 되므로 다시 계산
                // 계산 함수 호출
                calculatePrice();
        }

        // 체크 박스 전체 선택 및 해제
        function allChk1() {
                // 전체 선택을 위한 checkbox의 check 여부에 따라 전체 선택 및 전체 선택 해제를 수행하기위해 조건문 활요
                // 전체 선택 시 등록된 상품의 모든 checkbox에 check하기 위한 조건문
                if (cart__del.rows[0].cells[0].children[0].checked) {
                        // 등록된 상품의 checkbox의 name을 사전에 설정해 주었으므로, getElementByName으로 모든 상품들의 checkbox를 checkboxes변수를 선언하여 저장
                        var checkboxes = document.getElementsByName('checking');
                        // 모든 체크박스들을 돌면서 checkbox가 checked 되도록 수행
                        checkboxes.forEach(checkbox => {
                                checkbox.checked = true;
                        });
                } else {
                        // 전체 선택 해제를 위한 코드(전체 선택과 동일하게 수행되며, checked가 해제되도록 설정)
                        var checkboxes = document.getElementsByName('checking');
                        checkboxes.forEach(checkbox => {
                                checkbox.checked = false;
                        });
                }
        }
</script>

</html>
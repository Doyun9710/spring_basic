<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.example.model.BoardTO" %>
<%@ page import="com.example.model.CommentTO" %>

<% 
	request.setCharacterEncoding( "utf-8" );

	String cpage = request.getParameter( "cpage" );

	BoardTO to = (BoardTO)request.getAttribute( "to" );
	
	String seq = to.getSeq();
	String subject = to.getSubject();
	String writer = to.getWriter();
	String mail = to.getMail();
	String wip = to.getWip();
	String wdate = to.getWdate();
	String hit = to.getHit();
	String content = to.getContent();
	String filename = to.getFilename();
	String refilename = "없음";
	if( !filename.equals( "없음" ) ) {
		String filename1[] = filename.split( "_timestamp" );
		String filename2[] = filename.split( "\\." );
		refilename = filename1[0] + "." + filename2[1];
	}
			
	long filesize = to.getFilesize();
	String latitude = to.getLatitude();
	String longitude = to.getLongitude();
	
	String nextseq = to.getNextseq();
	String nextsub = to.getNextsub();
	String beseq = to.getBeseq();
	String besub = to.getBesub();
	
	String file = "";
	if( filesize != 0 ) {
		//file = "<a href='../../upload/" + filename + "'>(" + filesize + "Kbyte)";
		file = "<a href='./download.jsp?filename=" + filename + "'>" + filename + "(" + filesize + "Kbyte)";
	}
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/board_view.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	$( document ).ready( function() {
		$( '#cbtn' ).on( 'click', function() {
			// 답글목록 comment_list.do, return JSON
			// 답글쓰기 comment_write_ok.do, return flag
			let cwriter = $('#cwriter').val();
		    let cpassword = $('#cpassword').val();
		    let ccontent = $('#ccontent').val();
			writeComment(cwriter, cpassword, ccontent);
		});
		
		readComment();
	});
	const readComment = function() {
		$.ajax({
			url: './comment_list.do',
			type: 'get',
			data: {
				pseq: <%= seq %>
			},
			dataType: 'json',
			success: function( json ) {
				console.log( json );
				let sbHtml = "";
				$.each( json.data, function(index, cmt) {
					sbHtml += "<tr>" ;
					sbHtml += "<td class='coment_re' width='20%'>";
					sbHtml += "<strong>" + cmt.writer + "</strong> (" + cmt.wdate + ")";
					sbHtml += "<div class='coment_re_txt'>" + cmt.content + "</div>";
					sbHtml += "</td>";
					sbHtml += "</tr>";
				});
				
				$( '#result' ).html( sbHtml );
			},
			error: function() {
				console.log( '[에러]' );
			}
		});
	};
	const writeComment = function(cwriter, cpassword, ccontent) {
		$.ajax({
			url: './comment_write_ok.do',
			type: 'get',
			data: {
				pseq: $('#pseq').val(),
				cwriter: cwriter,
				cpassword: cpassword,
				ccontent: ccontent
			},
			dataType: 'json',
			success: function( json ) {
				if( json.flag == 0 ) {
					document.getElementById('cwriter').value = '';
					document.getElementById('cpassword').value = '';
					document.getElementById('ccontent').value = '';
					readComment();
					// location.reload();
				}
				else
					console.log( '[에러]' );
			},
			error: function() {
				console.log( '[에러]' );
			}
		});
	};
</script>
</head>

<body>
<!-- 상단 디자인 -->
<div class="contents1"> 
	<div class="con_title"> 
		<p style="margin: 0px; text-align: right">
			<img style="vertical-align: middle" alt="" src="./images/home_icon.gif" /> &gt; 커뮤니티 &gt; <strong>여행지리뷰</strong>
		</p>
	</div>

	<div class="contents_sub">	
	<!--게시판-->
		<div class="board_view">
			<table>
			<tr>
				<th width="10%">제목</th>
				<td width="60%"><%= subject %>(<%= wip %>)</td>
				<th width="10%">등록일</th>
				<td width="20%"><%= wdate %></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><%= writer %></td>
				<th>조회</th>
				<td><%= hit %></td>
			</tr>
			<tr>
				<th>위치정보</th>
				<td>
					위도 : (<%= latitude %>) / 경도 : (<%= longitude %>)
					<input type="button" value="지도보기" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='https://www.google.com/maps/@<%= latitude %>,<%= longitude %>,17z'" /> 
				</td>
				<th>파일</th>
				<td><%= refilename %></td>
			</tr>
			<tr>
				<td colspan="4" height="200" valign="top" style="padding:20px; line-height:160%">
					<div id="bbs_file_wrap">
						<div>
							<%
								if( filename != "없음" )
									out.println( "<img src='./upload/" + filename + "' width='900' onerror='' /><br />" );
								else
									out.println( "<img src='./images/noimage.jpg' width='300' onerror='' /><br />" );
							%>
						</div>
					</div>
					<%= content %>
				</td>
			</tr>			
			</table>
			
			<table id="result">
			</table>

			<!-- <form action="comment_write_ok.do" method="post" name="cfrm"> -->
			<input type="hidden" id="cpage" value="<%= cpage %>" />
			<input type="hidden" id="pseq" value="<%= seq %>" />
			<table>
			<tr>
				<td width="94%" class="coment_re">
					글쓴이 <input type="text" id="cwriter" maxlength="5" class="coment_input" />&nbsp;&nbsp;
					비밀번호 <input type="password" id="cpassword" class="coment_input pR10" />&nbsp;&nbsp;
				</td>
				<td width="6%" class="bg01"></td>
			</tr>
			<tr>
				<td class="bg01">
					<textarea id="ccontent" cols="" rows="" class="coment_input_text"></textarea>
				</td>
				<td align="right" class="bg01">
					<input type="button" id="cbtn" value="댓글등록" class="btn_re btn_txt01" />
				</td>
			</tr>
			</table>
			<!-- </form> -->
		</div>
		<div class="btn_area">
			<div class="align_left">
				<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='list.do?cpage=<%= cpage %>'" />
			</div>
			<div class="align_right">
				<input type="button" value="수정" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='modify.do?cpage=<%= cpage %>&seq=<%= seq %>'" />
				<input type="button" value="삭제" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='delete.do?cpage=<%= cpage %>&seq=<%= seq %>'" />
				<input type="button" value="쓰기" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='write.do?cpage=<%= cpage %>'" />
			</div>
		</div>
		<!--//게시판-->
		
		<!-- 이전글 / 다음글 -->
		<div class="next_data_area">
			<span class="b">다음글 | </span><a href="view.do?cpage=<%= cpage %>&seq=<%= nextseq %>"><%= nextsub %></a>
		</div>
		<div class="prev_data_area">
			<span class="b">이전글 | </span><a href="view.do?cpage=<%= cpage %>&seq=<%= beseq %>"><%= besub %></a>
		</div>
		<!-- //이전글 / 다음글 -->
	</div>
<!-- 하단 디자인 -->
</div>

</body>
</html>

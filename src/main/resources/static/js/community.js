/*
提交回复
 */
function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    comment2target(questionId, 1, content);
}

function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-" + commentId).val();
    comment2target(commentId, 2, content);
}


function comment2target(targetId, type, content) {

    if (!content) {
        alert("不能回复空内容");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type
        }),

        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2003) {

                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=b52281b4b015c663f402&redirect_uri=http://localhost:8887/callback&N&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                }
            }
            console.log(response);
        },
        dataType: "json"
    });
}

/*
展开二级回复
 */
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);
    //获取二级评论展开状态
    var collapse = e.getAttribute("data-collapse");

    if (collapse) {
        //折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    } else {
        var subCommentContainer=$("#comment-"+id);
        console.log(subCommentContainer.children())
        if (subCommentContainer.children().length!=1){
            //展开二级评论
            comments.addClass("in");
            //标记二级评论展开状态
            e.setAttribute("data-collapse", "in");
            e.classList.add("active");
        }else {
            $.getJSON("/comment/" + id, function (data) {
                var items = [];
                $.each(data.data.reverse(), function (index,comment) {

                    var mediaLeftElement=$("<div/>",{
                        "class":"media-left"
                    }).append($("<img/>",{
                        "class":"media-object",
                        "src":comment.user.avatarUrl
                    }));
                    var mediaBodyElement =$("<div/>",{
                        "class":"media-body"
                    }).append($("<h5/>",{
                        "class":"media-heading",
                        "html":comment.user.name
                    })).append($("<div/>",{
                        "html":comment.content
                    })).append($("<div/>",{
                        "class":"menu"
                    }).append($("<div/>",{
                        "class":"pull-right",
                        "html":moment(comment.gmtCreat).format('YYYY-MM-DD')
                    })));

                    var mediaElement=$("<div/>",{
                        "class":"media"
                    }).append(mediaLeftElement)
                        .append(mediaBodyElement);

                    var commentElement = $("<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm12 col-xs-12 comment",
                    }).append(mediaElement);
                    subCommentContainer.prepend(commentElement);
                });
                comments.addClass("in");
                //标记二级评论展开状态
                e.setAttribute("data-collapse", "in");
                e.classList.add("active");
            });
        }
    }
}

function selectTag(e) {
    var value = e.getAttribute("data-tag");
    var previous =$("#tag").val();
    //如果存在相同标签，则不添加标签了
    if (previous.indexOf(value)==-1){
        if (previous){
            $("#tag").val(previous+","+value);
        }else {
            $("#tag").val(value);
        }
    }
}

function showSelectTag() {
    $("#select-tag").show();
}
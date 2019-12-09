package life.mashangkaishi.manongcommunity.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"你想要的值不存在，换一个试试？"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题进行回复"),
    NO_LOGIN(2003, "未登录,无法进行评论,请登录后重试"),
    SYS_ERROR(2004,"服务器未就绪，稍后再看看吧...."),
    TYPE_PARAM_WRONG(2005,"评论类型错误，或不存在"),
    COMMENT_NOT_FOUND(2006,"你操作的评论不存在了"),
    COMMENT_IS_EMPTY(2007,"输入内容不能为空"),
    READ_NOTIFICATION_FAIL(2008,"偷看？too young too naive"),
    NOTIFICATION_NOT_FOUND(2009,"消息已被删除"),
    FILE_UPLOAD_FAIL(2010,"图片上传失败");

    @Override
    public String getMessage(){
        return message;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    private String message;
    private Integer code;
    CustomizeErrorCode(Integer code, String message){
        this.code=code;
        this.message=message;
    }



}

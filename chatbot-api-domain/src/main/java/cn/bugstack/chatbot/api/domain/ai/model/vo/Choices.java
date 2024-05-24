package cn.bugstack.chatbot.api.domain.ai.model.vo;

/**
 * @author 小傅哥，微信：fustack
 * @description 选择
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class Choices {

    private int index;
    private Message message;
    private String logprobs;
    private String finish_reason;

    // Getters and Setters
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(String logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    public static class Message {
        private String role;
        private String content;

        // Getters and Setters
        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}


//package cn.bugstack.chatbot.api.domain.ai.model.vo;
//
///**
// * @author 小傅哥，微信：fustack
// * @description 选择
// * @github https://github.com/fuzhengwei
// * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
// */
//public class Choices {
//
//    private String text;
//
//    private int index;
//
//    private String logprobs;
//
//    private String finish_reason;
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public int getIndex() {
//        return index;
//    }
//
//    public void setIndex(int index) {
//        this.index = index;
//    }
//
//    public String getLogprobs() {
//        return logprobs;
//    }
//
//    public void setLogprobs(String logprobs) {
//        this.logprobs = logprobs;
//    }
//
//    public String getFinish_reason() {
//        return finish_reason;
//    }
//
//    public void setFinish_reason(String finish_reason) {
//        this.finish_reason = finish_reason;
//    }
//}

package org.example;

public class MyClass {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "content='" + content + '\'' +
                '}';
    }
}

package www.silver.vo;

public class NoticeVO {
	int sequence = 0;
	String writer = null;
	String password = null;
	String title = null;
	String content = null;
	String secret = null;
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [sequence=" + sequence + ", writer=" + writer + ", password=" + password + ", title=" + title
				+ ", content=" + content + ", secret=" + secret + "]";
	}
	
	
}

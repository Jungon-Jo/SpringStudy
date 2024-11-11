package www.silver.vo;

public class UserVO {
	String type = null;
	String username = null;
	String userpassword = null;
	String title = null;
	String comments = null;
	String memberonly = null;
	String indate = null;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getMemberonly() {
		return memberonly;
	}

	public void setMemberonly(String memberonly) {
		this.memberonly = memberonly;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "UserVO [type=" + type + ", username=" + username + ", userpassword=" + userpassword + ", title=" + title
				+ ", comments=" + comments + ", memberonly=" + memberonly + ", indate=" + indate + "]";
	}

}

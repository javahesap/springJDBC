package com.proje.db;

public class Database {
private String driverClassNmame;
private String  url;
private String usernmae;
private String password;
public Database() {

	// TODO Auto-generated constructor stub
}
public Database(String driverClassNmame, String url, String usernmae, String password) {
	super();
	this.driverClassNmame = driverClassNmame;
	this.url = url;
	this.usernmae = usernmae;
	this.password = password;
}
public String getDriverClassNmame() {
	return driverClassNmame;
}
public void setDriverClassNmame(String driverClassNmame) {
	this.driverClassNmame = driverClassNmame;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getUsernmae() {
	return usernmae;
}
public void setUsernmae(String usernmae) {
	this.usernmae = usernmae;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}









}

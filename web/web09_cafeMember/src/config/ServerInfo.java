package config;
/*
 * 디비서버 정보의 상수값으로 구성된 인터페이스
 * Driver FQCN
 * DB server URL
 * DB server user
 * DB server password
 */
public interface ServerInfo {
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; // interface는 필드가 없어서 자동적으로 static final화 함
	String URL="jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String USER ="root";
	String PASSWORD="1234";
}

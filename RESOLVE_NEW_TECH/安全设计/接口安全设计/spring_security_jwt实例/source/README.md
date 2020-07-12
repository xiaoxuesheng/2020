# spring-security5-jwt
spring-security5+jwt demo
本项目是Spring security5+Jwt的基础实例，
简书对此项目简介：https://www.jianshu.com/p/fc56d965e3c3  
功能：  
    1：验证用户登录账号密码是否正确，登录地址可以自定义配置，密码验证规则也是自定义，我这里只要是123456就行，验证成功与失败分别有不同的类来处理，登录成功后生成JWT返回
    测试方法：http://localhost:8080/user/login?username=adm&password=123456  
    2：配置拦截除了"/test/**"以外的所有请求，登录地址配置好以后Spring security会自动设置为不拦截  
    3：配置了各种拦截器，具体看代码  
使用方法
1登录获取jwt token(在Response Header里)，POST http://localhost:8080/user/login?username=adm&password=123456
2根据token 调用ROLE_ADMIN权限接口, GET http://localhost:8080/role/aaa ，返回权限不足，,MyUserDetailsService默认给用户加了ROLE_USER权限
    根据token 调用无权限注解的接口, GET http://localhost:8080/role/bbb ，返回正常结果
    根据token 调用ROLE_USER权限接口, GET http://localhost:8080/role/ccc ，返回正常结果
3调用不存在的接口，返回捕获异常http://localhost:8080/tessssst/error

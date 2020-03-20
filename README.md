# wygl-system
vue+spring boot 小区物业管理系统 毕业设计

# 使用技术
前端：
  vue + element ui + axios
  
后台：
  1. spring boot 
  2. spring security + jwt 登录验证
  3. mybatis + mysql + druid 连接池 
  4. swagger-ui 
  
# 踩坑日记
  引入Spring Security 后导致原来的处理跨域的方式不生效（继承WebMvcConfigurer 实现 addCorsMappings 接口）。
  
  解决方法：
  1. 在  void configure(HttpSecurity http) 中添加 .and().cors()
  2. 添加一个Bean 
  ```java
     private CorsConfiguration buildConfig() {
                     CorsConfiguration corsConfiguration = new CorsConfiguration();
                     corsConfiguration.addAllowedOrigin("*");
                     corsConfiguration.addAllowedHeader("*");
                     corsConfiguration.addAllowedMethod("*");
                     corsConfiguration.addExposedHeader("Authorization");
                     return corsConfiguration;
                 }

      @Bean
      public CorsFilter corsFilter() {
          UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
          source.registerCorsConfiguration("/**", buildConfig());
          return new CorsFilter(source);
    }
  ```

   




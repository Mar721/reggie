可以通过账号查询是否该账号已经存在,但是在业务层根据查询的结果来控制是否要添加账号是不可靠的，
并发情况会出现插入两个相同账号的情况，所以在数据库的账号字段加唯一约束才可以

js对long型数据进行处理时会丢失精度，导致提交的id和数据库中的id不一致（js的long是16位）
可以在服务端给页面响应json数据时进行处理，将long型数据统一转为string字符串
配置如下
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("扩展消息转换器...");
        //创建消息转换器对象
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        //设置对象转换器，底层使用Jackson将Java对象转为json
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        //将上面的消息转换器对象追加到mvc框架的转换器集合中
        converters.add(0,messageConverter);
    }
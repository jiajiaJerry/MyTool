### 基于RESTful风格的网络请求框架设计



##### core 封装公共模块

使用构建者模式封装app全局配置,包括全局上下文,主机地址,拦截器,三方key...等等

使用方便,在项目Application里初始化只需:

```
Tool.init(this)
    .withIcon()
    .withLoaderDelayed()
    .withApiHost("")
    .withInterceptor()
    .withWeChatAppId("")
    .withWeChatAppSecret("")
    .configure();
```



##### annotations 用于自定义注解

自定义注解绕过微信固定包名



##### compiler 用于注解解析

解析注解,包括微信登录,支付等



网络请求基于RESTful风格统一处理请求

```
    @GET
    Call<String> get(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap WeakHashMap<String, Object> params);

    @POST
    Call<String> postRaw(@Url String url, @Body RequestBody body);

    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap WeakHashMap<String, Object> params);

    @PUT
    Call<String> putRaw(@Url String url, @Body RequestBody body);

    @DELETE
    Call<String> delete(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);
```



通过构建者模式请求:

```
RestClient.builder()
                .url("")	//url地址
                .loader(getContext())	//加载动画
                .params("", "")		//请求参数,重载方法可传HashMap
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
			//请求成功回调
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
			//请求失败回调
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
			//请求错误回调
                    }
                })
                .build()
                .get();
```









// axios不同于jquery.ajax. axios请求时不会在Headers中添加X-Requested-With标识请求类型。 以模拟jquery.ajax效果
axios.defaults.headers.common['X-Requested-With'] = "XMLHttpRequest";

// 添加请求拦截器
axios.interceptors.request.use(function(config) {
    return config;
}, function(error) {
    return Promise.reject(error);
});

// 添加响应拦截器
axios.interceptors.response.use(function(response) {
    var code = response.data.code;
    if (code == 99 || code == 100) {
        // 非业务允许范围的状态(未登录或未处理异常)
        var callBackUrl = response.data.data.error_call_back;
        window.location.href = callBackUrl;
    }
    return response;
}, function(error) {
    return Promise.reject(error);
});

function linkerTo(args) {
    // 点击整个菜单行也会出发子节点(a标签)的点击事件,增大监听范围, 优化体验
    args.firstChild.click();
}
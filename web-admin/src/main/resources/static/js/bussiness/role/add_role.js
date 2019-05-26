var page = new Vue({
    el:"#main",
    data: {
        addRoleForm:{
            roleName:"",
            roleComment:""
        }
    },
    mounted:function(){

    },
    methods:{
        submitForm: function (formName) {
            this.$refs[formName].validate(function(valid){
                if(valid) {
                    const loading = page.$loading({
                        text:"保存中..."
                    });
                    axios({
                        url: '/role/saveRole?roleName='+page.addRoleForm.roleName+"&roleComment="+page.addRoleForm.roleComment,
                        method: 'get',
                    }).then(function (response) {
                        if(response.data.code == 0){
                            loading.close();
                            window.location.href="/role/toRoleList";//返回角色列表
                        }else{
                            loading.close();
                            page.$notify.warning({
                                title: '保存失败',
                                message: response.data.message
                            });
                        }
                    }).catch(function (error) {
                        loading.close();
                        page.$notify.error({
                            title: '保存失败',
                            message: '请检查网络连接或刷新页面重试!'
                        });
                    });
                }else{
                    return false;
                }
            });
        },
        back:function() {
            window.history.back(-1);
        }
    }
});

var page = new Vue({
    el:"#main",
    data: {
        addRoleForm:{
            roleId:"",
            roleName:"",
            roleComment:""
        }
    },
    mounted:function(){
        const loading = this.$loading({
            text:"加载中..."
        });
        axios({
            url: '/role/initRoleDetail?roleId='+ $("#hiddenRoleId").val(),
            method: 'get',
        }).then(function (response) {
            if(response.data.code == 0){
                loading.close();
                var role = response.data.data;
                page.addRoleForm.roleName = role.roleName;
                page.addRoleForm.roleComment = role.remark;
                page.addRoleForm.roleId = role.id;
            }else{
                loading.close();
                page.$notify.warning({
                    title: '错误',
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
    },
    methods:{
        submitForm: function (formName) {
            this.$refs[formName].validate(function(valid){
                if(valid) {
                    const loading = page.$loading({
                        text:"保存中..."
                    });
                    axios({
                        url: '/role/updateRole?roleName='+page.addRoleForm.roleName+"&roleRemark="+page.addRoleForm.roleComment+"&id="+page.addRoleForm.roleId,
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

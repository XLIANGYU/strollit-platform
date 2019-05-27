var page = new Vue({
    el:"#main",
    data: {
        roleList: null,
        //时间选择框所需数据
        startTime: "",
        endTime: "",
        //分页所需数据
        pageIndex: 1,
        pageSize: 10,
        pageTotal: 0,
        roleName: "",
        deleteIds:""
    },
    mounted:function(){
        this.init();
    },
    methods:{
        init:function(){
            //alert(this.startTime + "," +this.endTime +"," + this.roleName);
            const loading = this.$loading({
                text:"加载中..."
            });
            var params = new URLSearchParams();
            params.append('pageIndex', this.pageIndex);
            params.append('pageSize', this.pageSize);
            params.append('name', this.roleName);
            axios({
                method: 'post',
                url: '/role/initRoles',
                data: params,
                headers: {
                    'Content-type': 'application/x-www-form-urlencoded'
                }
            }).then(function (response) {
                var data = response.data.data.roles;
                //设置分页显示的数据
                if(response.data.code == 0){
                    loading.close();
                    page.pageTotal = data.total;
                    page.roleList = data.list;
                }else{
                    loading.close();
                    page.$notify.warning({
                        title: '加载失败',
                        message: response.data.message
                    });
                }
            }).catch(function (error) {
                loading.close();
                page.$notify.error({
                    title: '加载失败',
                    message: '请检查网络连接或刷新页面重试!'
                });
            });
        },
        handleSelectionChange:function(val) {
            this.multipleSelection = val;
            //获取选中行的隐藏ID
            var ids = "";
            for(var i = 0; i < val.length; i++){
                ids += val[i].id + ",";
            }
            page.deleteIds = ids;
        },
        handleSizeChange:function(val) {
            page.pageSize = val;
            page.init();
        },
        handleCurrentChange:function(val) {
            page.pageIndex = val;
            page.init();
        },
        toAddRole:function(){
            //新增按钮点击
            window.location.href="/role/toAddRole";
        },
        doSearch:function(){
            page.init();
        },
        viewDetailHandle:function(index,row){
            //跳转到查看详情页
            window.location.href="/role/toEditRole?roleId="+row.id;
        },
        deleteRole:function() {
            if(page.deleteIds == ""){
                page.$alert('请先选择需要删除的内容!', '删除失败', {
                    confirmButtonText: '确定',
                    callback: function () {
                        // Skip
                    }
                });
                return;
            }
            this.$confirm('点击确定将删除选中的角色信息, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(function () {
                var params = new URLSearchParams();
                params.append('ids', page.deleteIds);
                axios({
                    method: 'post',
                    url: '/role/batchRemove',
                    data: params,
                    headers: {
                        'Content-type': 'application/x-www-form-urlencoded'
                    }
                }).then(function (response) {
                    if(response.data.code == 0){
                        page.$message({
                            message: response.data.message,
                            type: 'success'
                        });
                        page.init();
                    }else{
                        page.$message.error('删除失败,请检查网络连接或刷新页面重试!');
                    }
                }).catch(function (error) {
                    loading.close();
                    page.$notify.error({
                        title: '删除失败',
                        message: '请检查网络连接或刷新页面重试!'
                    });
                });
            }).catch(function(){
                //点击了取消
            });
        }
    }
});

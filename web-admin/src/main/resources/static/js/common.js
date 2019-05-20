function linkerTo(args) {
    // 点击整个菜单行也会出发子节点(a标签)的点击事件,增大监听范围, 优化体验
    args.firstChild.click();
}

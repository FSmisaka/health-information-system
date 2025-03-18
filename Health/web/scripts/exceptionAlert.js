function showMessage(message) {
    switch (message) {
        case "successfulUpdate":
            alert("更新成功！");
            break;
        case "failedUpdate":
            alert("更新失败！");
            break;
        case "failedDelete":
            alert("删除失败！");
            break;
        case "successfulDelete":
            alert("删除成功！");
            break;
        case "failedSearch":
            alert("未查找到有关记录！");
            break;
        case "successfulInsert":
            alert("成功新增！");
            break;
        case "failedInsert":
            alert("新增数据失败！");
            break;
        default:
            break;
    }
}

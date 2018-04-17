function getTree() {
    // Some logic to retrieve, or generate tree structure
    return catalogBootstrapTreeview;
}

$('#tree').treeview({data: getTree()});
"use strict";

let item = $('#drinkPrice')

$('#descending').on('click', () => {
    item.sortElements(function (a, b) {
        return parseFloat($(a).text()) < parseFloat($(b).text()) ? 1 : -1;
    });
});
$('#ascending').on('click', () => {
    item.sortElements(function (a, b) {
        return parseFloat($(a).text()) > parseFloat($(b).text()) ? 1 : -1;
    });
});

jQuery.fn.sortElements = (function () {
    var sort = [].sort;
    return function (comparator, getSortable) {
        getSortable = getSortable || function () {
            return this;
        };
        var placements = this.map(function () {
            var sortElement = getSortable.call(this),
                parentNode = sortElement.parentNode,
                nextSibling = parentNode.insertBefore(
                    document.createTextNode(''),
                    sortElement.nextSibling
                );
            return function () {
                if (parentNode === this) {
                    throw new Error(
                        "You can't sort elements if any one is a descendant of another."
                    );
                }
                parentNode.insertBefore(this, nextSibling);
                parentNode.removeChild(nextSibling);
            };
        });
        return sort.call(this, comparator).each(function (i) {
            placements[i].call(getSortable.call(this));
        });
    };
})();
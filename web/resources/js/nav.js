/* nav.js · dropdown "Menu" (desktop) e acordeão (menu lateral mobile) */
(function () {
    'use strict';

    // ---- Desktop / tablet ----
    var btn = document.getElementById('nmBtn');
    var panel = document.getElementById('nmPanel');

    if (btn && panel) {
        var setOpen = function (open) {
            panel.hidden = !open;
            btn.setAttribute('aria-expanded', String(open));
        };

        btn.addEventListener('click', function (e) {
            e.stopPropagation();
            setOpen(panel.hidden);
        });

        document.addEventListener('click', function (e) {
            if (!panel.hidden && !panel.contains(e.target)) setOpen(false);
        });

        document.addEventListener('keydown', function (e) {
            if (e.key === 'Escape' && !panel.hidden) {
                setOpen(false);
                btn.focus();
            }
        });
    }

    // ---- Mobile ----
    var mBtn = document.getElementById('nmMobileBtn');
    var mList = document.getElementById('nmMobileList');

    if (mBtn && mList) {
        mBtn.addEventListener('click', function () {
            var open = mList.hidden;
            mList.hidden = !open;
            mBtn.setAttribute('aria-expanded', String(open));
        });
    }
})();
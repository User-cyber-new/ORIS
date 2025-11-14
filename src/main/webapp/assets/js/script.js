const menuItems = document.querySelectorAll('[data-js-main-nav]');

menuItems.forEach(item => {
    item.addEventListener('mouseenter', () => {
        item.classList.add('main-nav-change-bacground');
    });
    item.addEventListener('mouseleave', () => {
        item.classList.remove('main-nav-change-bacground');
    });
});

// Находим элементы
const openBtn = document.querySelector('[data-js-enter-logo]');
const popup = document.querySelector('[data-js-popup]');
// const closeBtn = document.querySelector('[data-js-closeBtn]');
const popupContent = document.querySelector('[data-js-popup-content]');

// При клике на изображение — показать окно
if (!openBtn || !popup) {
    console.warn('openBtn, popup или closeBtn не найдены. Проверьте селекторы.');
} else {
    // Показать попап
    openBtn.addEventListener('click', () => {
        popup.classList.remove('hidden');
        popup.classList.add('show');
    });

    // Закрыть по кнопке "Закрыть"
    // closeBtn.addEventListener('click', () => {
    //     popup.classList.remove('show');
    //     popup.classList.add('hidden');
    // });

    // Закрыть кликнув по затемнённой области вне .popup-content
    popup.addEventListener('click', (e) => {
        if (!popupContent.contains(e.target)) {
            popup.classList.remove('show');
            popup.classList.add('hidden');
        }
    });

    // Закрыть по клавише Esc
    document.addEventListener('keydown', (e) => {
        if (e.key === 'Escape' && popup.classList.contains('show')) {
            popup.classList.remove('show');
            popup.classList.add('hidden');
        }
    });
}

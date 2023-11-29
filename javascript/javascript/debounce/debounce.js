const debounce = (fn, wait = 0) => {
    let timerId;

    return function (...args) {
        window.clearTimeout(timerId);
        timerId = setTimeout(() => {
            fn.apply(this, args);
        }, wait);
    }
}
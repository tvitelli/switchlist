<!-- javascript to validate reporting mark field entry using regex validation string -->
let reportingMark = document.getElementById('reportingMark');
let equipment = document.getElementById('equipment');
let reportingMarkErr = document.getElementById('reportingMarkErr');

reportingMark.addEventListener('input', function(e) {
    let pattern = /(^([A-Z]{2,4})([0-9]{1,6})$)/;
    let currentValue = e.target.value;
    let valid = pattern.test(currentValue);

    if (valid) {
        reportingMarkErr.style.display = 'none'
    } else {
        reportingMarkErr.placeholder = "Enter Reporting Mark in format AAAA000000"
    }
})
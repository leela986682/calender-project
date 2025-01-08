function setTime(hours, minutes, seconds) {
    const hourHand = document.getElementById("hour-hand");
    const minuteHand = document.getElementById("minute-hand");
    const secondHand = document.getElementById("second-hand");

    const hourDeg = (hours % 12) * 30 + minutes * 0.5;
    const minuteDeg = minutes * 6;
    const secondDeg = seconds * 6;

    hourHand.style.transform = `rotate(${hourDeg}deg)`;
    minuteHand.style.transform = `rotate(${minuteDeg}deg)`;
    secondHand.style.transform = `rotate(${secondDeg}deg)`;
}
function setDate(date, day, month) {
    const Date = document.getElementById("date");
    const Day = document.getElementById("day");
    const Month = document.getElementById("month");
    Date.textContent = date;
    Day.textContent = day;
    Month.textContent = month;
}
// function fetchUpdate() {
//     fetch('dataServlet')
//         .then(res => res.json())
//         .then(arr => {
//             console.log(arr)
//             arr.forEach(data => {
//                 setDate(data.date, data.day, data.month)
//                 setTime(9, 50, 20)
//             });
//         })
//         .catch(err => console.log(err))
// }
setTime(3,0,10);
function update(){
	seconds++;
	if(seconds==60){
		seconds=0;
		minutes++;
	}
	if(minutes==60){
		minutes=0;
		hours++;
	}
	if(hours==24){
		hours=0;
	}
	setTime(hours,minutes,seconds)
}
setInterval(()=>{}, 1000);
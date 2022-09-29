import React, { useState } from "react";
import axios from "axios";
import { useEffect } from "react";
import swal from "sweetalert";
import { useHistory } from "react-router";

function Pay() {
    const [amount, setAmount] = useState('');
    const [appointmentId,setappointmentId] = useState('');
    const [doctor, setDoctor] = useState({});
    const [patient, setPatient] = useState({});
    const [bookingId, setBookingId] = useState('');
    const history = useHistory();


    useEffect(()=>{
        // let obj = JSON.parse(sessionStorage.getItem("amount"));
        // console.log(obj.amount);
        
        // setAmount(obj.amount);
        let book = JSON.parse(sessionStorage.getItem("conBooking"))
        let bookId = book.data.bookingId;
        console.log(book);
        console.log(bookId);
        setBookingId(bookId);

        
    },[])

    function loadScript(src) {
        return new Promise((resolve) => {
            const script = document.createElement("script");
            script.src = src;
            script.onload = () => {
                resolve(true);
            };
            script.onerror = () => {
                resolve(false);
            };
            document.body.appendChild(script);
        });
    }

    async function displayRazorpay() {
        const res = await loadScript(
            "https://checkout.razorpay.com/v1/checkout.js"
        );

        if (!res) {
            alert("Razorpay SDK failed to load. Are you online?");
            return;
        }
        let data = {"amount":doctor.fees, "patientId":patient.patientId,
                    "appointmentId":appointmentId};
                    console.log(data);
                    console.log(amount);
                    
                    let obj = {"amount":JSON.parse(sessionStorage.getItem("amount"))}
        const result = await axios.post(`http://localhost:4000/api/pay/create_order`,obj);

        if (!result) {
            alert("Server error. Are you online?");
            return;
        }
        sessionStorage.removeItem("amount");

        var { amount, id: order_id, currency } = result.data;
        amount = amount * 100;

        const options = {
            key: "rzp_test_DPglbRcWUINn6L", // Enter the Key ID generated from the Dashboard
            amount: amount.toString(),
            currency: "INR",
            name: "Donation",
            description: "Test Transaction",
            order_id: order_id,
            handler: async function (response) {
                const data = {

                    orderCreationId: order_id,
                    razorpayPaymentId: response.razorpay_payment_id,
                    razorpayOrderId: response.razorpay_order_id,
                    razorpaySignature: response.razorpay_signature,
                    patientId:patient.patientId,
                    appointmentId:appointmentId
                }; 
                console.log(data);
                let d = {"bookingid":5,
                         "razorpayPaymentId":data.razorpayPaymentId};

                axios.put(`http://localhost:4000/api/pay/update_pay_order`, data)
                .then(res=>{
                    // alert("Payment Success");
                    swal("Payment Success","You Appointment Booked, Details Sent, Redirecting to Profile Page","success");
                // navigate(`/patient`);
                history.push(`/car_type`);
                })
                .catch(err=>{alert("error")});

                // alert("Payment Success");
            },
            prefill: {
                name: "",
                email: "",
                contact: "",
            },
            notes: {
                address: "",
            },
            theme: {
                color: "#61dafb",
            },
        };

        const paymentObject = new window.Razorpay(options);
        paymentObject.open();
    }

    return (
        <div >
            <h1>Checkout to do Payement </h1>
             <label>Fees to Pay to Book Appoinment </label>
                <h3>Amount : {JSON.parse(sessionStorage.getItem("amount"))}</h3>
              &emsp;  <button className="btn btn-success btn-lg" onClick={displayRazorpay}>
                   Confirm 
                </button>
        </div>
    );
}

export default Pay;
import React,{useState} from 'react'


function BillInfomation({totalP}) {

  return (
    <div class="col-md-4">
      <div class="bill">
          <div class="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
              <span class="text-black-50" >Tạm tính:</span>
              <span class="text-primary" id="sub-tot =al-money">{totalP()} VND</span>
          </div>
          <div class="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
              <span class="text-black-50">VAT (10%):</span>
              <span class="text-primary" id="vat-money">{totalP()*0.1} VND</span>
          </div>
          <div class="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
              <span class="text-black-50">Thành tiền:</span>
              <span class="text-primary" id="totalP-money">{totalP()+(totalP()*0.1)} VND</span>
          </div>
        </div>
    </div>
  )
}

export default BillInfomation
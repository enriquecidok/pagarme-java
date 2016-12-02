package me.pagar.model.response;

import lombok.Builder;
import lombok.NoArgsConstructor;
import me.pagar.model.Payable;

@NoArgsConstructor
public class PayableResponse extends Payable implements ResponseObject{
	
	@Builder
	public PayableResponse(String status, String amount, String fee, String installment, String transactionId,
			String splitRuleId, String paymentDate, String type) {
		super(status, amount, fee, installment, transactionId, splitRuleId, paymentDate, type);
		// TODO Auto-generated constructor stub
	}

	
}

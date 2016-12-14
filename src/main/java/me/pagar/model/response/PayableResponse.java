package me.pagar.model.response;

import org.joda.time.DateTime;

import lombok.NoArgsConstructor;
import me.pagar.enumeration.PayableStatus;
import me.pagar.enumeration.PayableType;
import me.pagar.model.Payable;

@NoArgsConstructor
public class PayableResponse extends Payable implements ResponseObject{
	public PayableResponse(PayableStatus status, Integer amount, Integer fee, Integer installment, String transactionId, String splitRuleId, DateTime paymentDate, PayableType type) {
		super(status, amount, fee, installment, transactionId, splitRuleId, paymentDate, type);
	}
}

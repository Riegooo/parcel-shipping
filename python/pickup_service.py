from billable import Billable


class PickupService(Billable):

    def __init__(self, customer, fee):
        self.customer = customer
        self.fee = 0
        self.set_fee(fee)

    def set_fee(self, fee):
        if fee > 0:
            self.fee = fee

    def compute_fee(self):
        return self.fee

    def get_label(self):
        return self.customer

    def print_report(self):
        print(f"Pickup - {self.customer}: {self.fee:.2f}")
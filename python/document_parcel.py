from parcel import Parcel

class DocumentParcel(Parcel):

    def __init__(self, tracking_no, weight_kg, express=False):
        super().__init__(tracking_no, weight_kg)
        self.express = express

    def compute_fee(self):
        fee = self.get_weight_kg() * 40

        if self.express:
            fee += 100
        

        return fee
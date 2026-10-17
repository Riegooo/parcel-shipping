from parcel import Parcel

class FragileParcel(Parcel):

    def __init__(self, tracking_no, weight_kg, declared_value):
        super().__init__(tracking_no, weight_kg)
        self.declared_value = declared_value

    def compute_fee(self):
        return (
            self.get_weight_kg * 60 +
            self.declared_value * 0.02
        )

    def print_report(self):
        super().print_report()

        print(f" Declared value: {self.declared_value:.2f}")
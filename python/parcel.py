from abc import abstractmethod
from billable import Billable


class Parcel(Billable):

    VAT_RATE = 0.12
    _parcel_count = 0

    def __init__(self, tracking_no, weight_kg):
        self.tracking_no = tracking_no

        if weight_kg <= 0:
            self.__weight_kg = 0
            print("Invalid weight.")
        else:
            self.__weight_kg = weight_kg

        Parcel._parcel_count += 1

    def get_weight_kg(self):
        return self.__weight_kg

    @classmethod
    def get_parcel_count(cls):
        return Parcel._parcel_count

    @abstractmethod
    def compute_fee(self):
        pass

    def compute_fee_with_vat(self):
        return self.compute_fee() * (1 + self.VAT_RATE)

    def print_report(self):
        print(
            f"Parcel [{self.tracking_no}] - "
            f"{self.__weight_kg} kg"
        )

    def get_label(self):
        return self.tracking_no
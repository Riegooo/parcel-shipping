from abc import ABC, abstractmethod

class Billable(ABC):

    @abstractmethod
    def compute_fee(self):
        pass
    
    @abstractmethod
    def print_report(self):
        pass

    @abstractmethod
    def get_label(self):
        pass

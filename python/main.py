from document_parcel import DocumentParcel
from fragile_parcel import FragileParcel
from pickup_service import PickupService
from parcel import Parcel

def main():

    items = [
        DocumentParcel("PH-1001", 0.5, True),
        DocumentParcel("PH-1002", 2.0),
        FragileParcel("PH-2001", 3.0, 10000),
        FragileParcel("PH-2002", 5.0, 2500),
        PickupService("Juan Dela Cruz", 50.00)
    ]

    while True:
        menu_choices = [
                "=====MENU=====",
                "1. Display all",
                "2. Search by keyword",
                "3. Show total and highest",
                "0. Exit",
        ]

        for menu in menu_choices:
            print(menu)


        try:
            user_choice = int(input("Enter choice: "))
        except ValueError:
            print("Invalid option.")
            continue

        if user_choice == 1:
            for item in items:
                item.print_report()

        elif user_choice == 2:
            keyword_entered = input("Enter keyword: ").strip().lower()
            found = False

            for item in items:
                if keyword_entered in item.get_label().lower():
                    item.print_report()
                    found = True

            if not found:
                print("No match found.")

        elif user_choice == 3:
            total = 0
            highest = None
            highest_fee = float("-inf")

            for item in items:
                fee = item.compute_fee()
                total += fee

                if fee > highest_fee:
                    highest_fee = fee
                    highest = item

            print(f"Total: {total:.2f}")

            if highest is not None:
                print(
                    f"Highest: {highest.get_label()} "
                    f"({highest_fee:.2f})"
                )

        elif user_choice == 0:
            print("Goodbye!")
            break

        else:
            print("Invalid option.")

    print("\n=== TASK 6 ===")

    print("get_item(2):")
    item = get_item(items, 2)

    if item is None:
        print("Invalid selection")
    else:
        item.print_report()

    print("get_item(10):")
    item = get_item(items, 10)

    if item is None:
        print("Invalid selection")
    else:
        item.print_report()

    print("get_item(-1):")
    item = get_item(items, -1)

    if item is None:
        print("Invalid selection")
    else:
        item.print_report()

    print(
        'format_tracking(" ph-1001 ") -> '
        f'{format_tracking(" ph-1001 ")}'
    )

    print(f"Parcel count: {Parcel.get_parcel_count()}")


def get_item(items, index):
    if items is None or index < 0 or index >= len(items):
        return None

    return items[index]


def format_tracking(s):
    if s is None:
        return ""

    return s.strip().upper().replace("-", " | ")

if __name__ == "__main__":
    main()
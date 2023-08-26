package me.gamerduck.safeapi.common.economy;

public record EconomyResponse(double amount, double balance,
                              ResponseType type, String errorMessage) {

    public enum ResponseType {
        SUCCESS(1),
        FAILURE(2),
        NOT_IMPLEMENTED(3);

        private int id;

        ResponseType(int id) {
            this.id = id;
        }

        int getId() {
            return id;
        }
    }

    public boolean transactionSuccess() {
        return type == ResponseType.SUCCESS;
    }

    public boolean transactionFailure() {
        return type == ResponseType.FAILURE;
    }
}
